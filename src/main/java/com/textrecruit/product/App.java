package com.textrecruit.product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.textrecruit.model.ItemElement;
import com.textrecruit.model.ItemsList;
import com.textrecruit.util.Config;

public class App {
	public static void main(String[] args) {
		try {
			RestClient restClient = new RestClient();
			ClientResponse response = restClient
					.getResponse("application/json");
			JsonNode root = restClient.getRootNode(response);
			StringBuffer stringBuffer = new StringBuffer();
			ObjectMapper objectMapper = new ObjectMapper();
			ItemsList data = objectMapper.readValue(root.toString(), ItemsList.class);
			ItemElement[] itemData = data.getItems();
			for(int i=0;i<itemData.length;i++) {
				stringBuffer.append("data : "+itemData[i]+"\n");
				stringBuffer.append("MD5 :"+MD5(itemData[i].getUid())+"\n");
				//main thread
				stringBuffer.append("Thread name :"+ Thread.currentThread().getName() +"\n");
			}
			writeJsonToFile(stringBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	//ref : http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

	/**
	 * @param retsultJson
	 * @throws FileNotFoundException
	 */
	private static void writeJsonToFile(StringBuffer retsults)
			throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(
				Config.getSharedProperties("outputfilepath"), false))) {
			out.print(retsults);
		}
	}
}
