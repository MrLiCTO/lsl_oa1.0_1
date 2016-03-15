package com.shilong.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shilong.oa.domain.Department;

public class DepartmentUtils {
		public static List <Department> getAllDepartments(List <Department> topList){
			List <Department> trees=new ArrayList<Department>();
			treeList(topList,trees,"┣");
			
			return trees;
		}
		
		// 显示树
		private static void treeList(Collection<Department> topList,Collection <Department> trees, String prefix) {
			for (Department top : topList) {
				Department dept=new Department();
				// 顶点
				dept.setName(prefix + top.getName());
				dept.setId(top.getId());
				trees.add(dept);
				// 子树
				treeList(top.getChildren(), trees,">>" + prefix);
			}
		}
}
