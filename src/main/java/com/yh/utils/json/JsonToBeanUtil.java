package com.yh.utils.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 
 * @date 2015年4月22日 下午2:58:39
 */
public class JsonToBeanUtil {
	public static class Gmodel {
		private String packagename;
		private String classname;
		private List<Pojo> fileds;

		public String getPackagename() {
			return packagename;
		}

		public void setPackagename(String packagename) {
			this.packagename = packagename;
		}

		public String getClassname() {
			return classname;
		}

		public void setClassname(String classname) {
			this.classname = classname;
		}

		public String getDatetime() {
//			return DateUtil.formatDateTime(new Date());
			return null;
		}

		public String getImportname() {
			List<String> sb=new ArrayList<>();
			if (fileds != null && !fileds.isEmpty()) {
				for (Pojo p : fileds) {
					if ((p.getType()!=null && p.getType().startsWith("int")) || (p.getType()!=null && p.getType().startsWith("boolean"))) {
						// ....
					} else if (p.getType()!=null && p.getType().startsWith("List")) {
						if(!sb.contains("java.util.List")){
							sb.add("java.util.List");
						}
					}
				}
			}
			StringBuilder sbb=new StringBuilder();
			for(String s:sb){
				sbb.append("import ").append(s).append(";").append("\r\n");
			}
			return sbb.toString();
		}

		public List<Pojo> getFileds() {
			return fileds;
		}

		public void setFileds(List<Pojo> fileds) {
			this.fileds = fileds;
		}

	}

	public static class Pojo {
		private String name;
		private String type;
		private String parent;

		public String getName() {
			return name;
		}

		public String getUpername() {
			if(name==null){
				return null;
			}
			return name.substring(0, 1).toUpperCase() + name.substring(1);
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "Pojo [name=" + name + ", type=" + type + ", parent=" + parent + "]";
		}
	}

	public static List<Pojo> outList = new ArrayList<>();

	public static boolean contains(String t) {
		for (Pojo p : outList) {
			if (t != null && t.equals(p.getName())) {
				return true;
			}
		}
		return false;
	}

	public static void add(Pojo p) {
		if (!contains(p.getName())) {
			outList.add(p);
		}
	}

	public static void parse(String jsonStr, String pName) {
		jsonStr = jsonStr.replaceAll(": ", ":");
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		JSONArray jsonarray = jsonObject.names();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) JSONArray.toCollection(jsonarray);
		for (String s : list) {
			Pojo p = new Pojo();
			String t = s.substring(0, 1).toUpperCase() + s.substring(1);
			p.setName(s);
			p.setType("String");
			int i = jsonStr.indexOf(s);
			p.setParent(pName);
			if ("[".equals(jsonStr.substring(i + s.length() + 2, i + s.length() + 3))) {
				p.setType("List<" + t + ">");
				add(p);
				JSONArray tmp = jsonObject.getJSONArray(s);
				String te = tmp.toString().replaceFirst("\\[", "").replaceFirst("]", "");
				if (te.length() > 2) {
					parse(te, t);
				} else {
					Pojo p2 = new Pojo();
					p2.setName(null);
					p2.setType(null);
					p2.setParent(t);
					add(p2);
				}
			} else if ("{".equals(jsonStr.substring(i + s.length() + 2, i + s.length() + 3))) {
				JSONObject tmp = jsonObject.getJSONObject(s);
				p.setType(t);
				add(p);
				parse(tmp.toString(), t);
			} else {
				Object o = jsonObject.get(s);
				if (o instanceof Boolean) {
					p.setType("boolean");
				} else if (o instanceof Number) {
					p.setType("int");
				}
				add(p);
			}
		}
	}

	public static void genrator(String json, String packname) throws Exception {
		parse(json, null);
		Map<String, List<Pojo>> res = new HashMap<>();
		for (Pojo p : outList) {
			if (p.getParent() == null) {
				if (!res.containsKey("Root")) {
					res.put("Root", new ArrayList<Pojo>());
				}
				res.get("Root").add(p);
			} else {
				if (!res.containsKey(p.getParent())) {
					res.put(p.getParent(), new ArrayList<Pojo>());
				}
				res.get(p.getParent()).add(p);
			}
		}
		List<Gmodel> list = new ArrayList<>();
		for (Map.Entry<String, List<Pojo>> c : res.entrySet()) {
			Gmodel m = new Gmodel();
			m.setPackagename(packname);
			m.setClassname(c.getKey());
			m.setFileds(c.getValue());
			list.add(m);
		}

		for (Gmodel l : list) {
			handle(l);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void handle(Gmodel g) throws Exception {
		String dir = JsonToBeanUtil.class.getResource("").getPath() + "\\";
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(dir));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setClassicCompatible(true);
		// 设置字符集
		cfg.setDefaultEncoding("UTF-8");
		// 设置尖括号语法和方括号语法,默认是自动检测语法
		// 自动 AUTO_DETECT_TAG_SYNTAX
		// 尖括号 ANGLE_BRACKET_TAG_SYNTAX
		// 方括号 SQUARE_BRACKET_TAG_SYNTAX
		cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
		String tmp=dir.substring(0, dir.indexOf("webapp/WEB-INF/classes/"))+"java/"+g.getPackagename().replaceAll("\\.", "\\\\")+"\\";
		Writer out = new OutputStreamWriter(new FileOutputStream(tmp + g.getClassname() + ".java"), "UTF-8");
		Template temp = cfg.getTemplate("Gmodle.ftl");
		Map map = new HashMap<>();
		map.put("m", g);
		temp.process(map, out);
		out.flush();
		System.out.println(g.getClassname()+"生成完成");
	}

	public static void main(String[] args) throws Exception {
		//生成Java bean
		String jsonStr = "{        'errors':[{'code': 10011, 'message': 'Inner auth error'}],        'messages':[],        'result':{                'priority': 0,               'locked': false,                'name': 'mx1.baidu.com',                'zone': '53fe2fee107d1a3d7adcbea6',                'proxiable': true,                     'proxied': false,                'isp_uuid': 'default',                'cf_id': '1c7c4781633e751db7203c80713185a5',                'content': '61.135.163.61',                'created_on': '2014-08-27T19:22:25.493000Z',                  'required_cname': null,                'ttl': 1,                'modified_on': '2014-08-27T19:22:25.493000Z',                'zone_name': 'baidu.com',                'type': 'A',                'id': '53fe2ff1107d1a3d7adcbed2'                },               'success': true      }";
//		String packname = "com.sjdf.eiss.utils.baidu.repsone";
//		JsonToBeanUtil.genrator(jsonStr, packname);
		
		//json 转化为对象
		Map<String, Class> classMap = new HashMap<String, Class>();  
//		classMap.put("errors", Errors.class);  
//		classMap.put("messages", Messages.class);  
//		classMap.put("result", Result.class);  
//		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
//		Root bean = (Root) JSONObject.toBean(jsonObject, Root.class,classMap);
//		System.out.println(bean.getErrors().get(0).getMessage());
	}
}
