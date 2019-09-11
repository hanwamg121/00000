package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import javax.servlet.ServletException; //import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.ejb.EJBAccessException;

import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.client.solrj.*;
import org.junit.Test;
import org.springframework.util.StringUtils;


public class ShowBean {
	private String keyWord;

	public List<Map> ListInit(HttpServletRequest request,
			HttpServletResponse response) //
			throws ServletException, IOException {
		List<Map> list = new ArrayList<Map>();// 创建list集合用于存入map的键值对集合

		try {
			final String solrUrl = "http://localhost:8081/solr/new_core";

			// 创建solrClient同时指定超时时间，不指定走默认配置

			HttpSolrClient solrServer = new HttpSolrClient.Builder(solrUrl)
					.withConnectionTimeout(10000).withSocketTimeout(60000)
					.build();
			HttpSolrClient client = new HttpSolrClient.Builder(solrUrl).build();

			String id;
			String filename;
			String length;
			String path;
			String filetext;
			// 获取用循环接收数据库的表格信息

			Map map = new HashMap();
			map.put("id", id);
			map.put("filename", filename);
			map.put("length", length);
			map.put("path", path);
			map.put("filetext", filetext);
			// 用键值对存入到map集合中
			list.add(map);// 在将map集合对象存入list集合
			/*
			 * for (Map map_1 :list) { System.out.println(map_1);
			 * }//在打印台遍历出数据查看是否有错误
			 */

			// 遍历结果集
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("key_list", list);// 将list集合数据放入到request中共享
		return list;

	}

	public void setKeyword(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyword() {
		return keyWord;
	}

}
