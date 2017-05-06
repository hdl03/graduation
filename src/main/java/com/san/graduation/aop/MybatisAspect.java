package com.san.graduation.aop;

import com.san.graduation.common.BaseEntity;
import com.san.graduation.common.constants.Constant;
import com.san.graduation.common.util.DateUtil;
import com.san.graduation.common.util.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 每一个插入，修改，都会插入插入时间和修改时间
 *
 *
 */

@Component
@Aspect
public class MybatisAspect {

	@Before("execution(* com.san.graduation.mapper..*.insert*(..))")
	public void doBeforeInsert(JoinPoint joinPoint){
		String className = joinPoint.getThis().toString();  
        String methodName = joinPoint.getSignature().getName(); // 获得方法名  
        String typeName=joinPoint.getSignature().getDeclaringTypeName();
        Logger.info(this,"位于：" + className + "调用" + methodName + "()方法-开始！代理类名字："+typeName);
        Object[] args = joinPoint.getArgs(); // 获得参数列表  
        if (args.length <= 0) {
			Logger.info(this,"====" + methodName + "方法没有参数");
        } else {  
            for (int i = 0; i < args.length; i++) {
				Logger.info(this,"====参数  " + (i + 1) + "：" + args[i]);
            	if(args[i] instanceof BaseEntity){
            		setBaseEntityData(args[i]);
            	}
            	if(args[i] instanceof List<?>){
            		List<?> list=(List<?>)args[i];
            		for(int j=0;j<list.size();j++){
            			if(list.get(j) instanceof BaseEntity){
            				setBaseEntityData(list.get(j));
            			}
            		}
            	}
            }  
        }  
		
	}
	
	@Before("execution(* com.shanlin.terminal.smim.mapper..*.update*(..))")
	public void doBeforeUpdate(JoinPoint joinPoint){
		String className = joinPoint.getThis().toString();  
        String methodName = joinPoint.getSignature().getName(); // 获得方法名  
		Logger.info(this,"位于：" + className + "调用" + methodName + "()方法-开始！");
        Object[] args = joinPoint.getArgs(); // 获得参数列表  
        if (args.length <= 0) {
			Logger.info(this,"====" + methodName + "方法没有参数");
        } else {  
            for (int i = 0; i < args.length; i++) {
				Logger.info(this,"====参数  " + (i + 1) + "：" + args[i]);
            	if(args[i] instanceof BaseEntity){
            		setBaseEntityData(args[i]);
            	}
            }  
        }  
	}
	
	/**
	 * 设置表基本信息
	 * 
	 * setBaseEntityData:(这里用一句话描述这个方法的作用). <br/> 
	 * (这里描述这个方法适用条件 – 可选).<br/> 
	 * (这里描述这个方法的执行流程 – 可选).<br/> 
	 * (这里描述这个方法的使用方法 – 可选).<br/> 
	 * (这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author huangdongliang
	 * @param data 
	 * @since JDK 1.8
	 */
	private void setBaseEntityData(Object data) {
		if (data instanceof BaseEntity) {
			BaseEntity baseEntity = (BaseEntity) data;
			if (baseEntity.getId() == null) {
				if (baseEntity.getCreatedBy() == null) {
					baseEntity.setCreatedBy("1");
					baseEntity.setCreatedAt(DateUtil.getDate());
				}
			} else {
				baseEntity.setUpdatedBy("1");
				baseEntity.setUpdatedAt(DateUtil.getDate());
			}
			// isDelete概念(通过它可以做一些数据的假删除，也可用在其他场合)
			if (baseEntity.getIsDelete() == null) {
				baseEntity.setIsDelete(Constant.DELETE_SIGN_NORMAL);
			}
		}
	}
	
	
}
