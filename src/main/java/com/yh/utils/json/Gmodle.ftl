package ${m.packagename};

${m.importname}
/** 
 * @date ${m.datetime}
 */
public class ${m.classname} {

	<#list m.fileds as f>
	<#if f.type??>
	private ${f.type} ${f.name};
	</#if>
	</#list>
	
	<#list m.fileds as f>
	<#if f.type??>
	public void set${f.upername}(${f.type} ${f.name}){
		this.${f.name}=${f.name};
	}
	
	public ${f.type} get${f.upername}(){
		return ${f.name};
	}
	</#if>
	</#list>
}
