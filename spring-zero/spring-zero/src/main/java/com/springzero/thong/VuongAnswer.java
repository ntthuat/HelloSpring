package com.springzero.thong;

import java.util.HashMap;
import java.util.Map;

public class VuongAnswer {



	static Map<String, DataNode> rootsMap = null;
	static Map<String, DataNode> dataMap = null;

	public static void main(String[] args) {

		rootsMap = new HashMap<>();
		//init data
		dataMap = new HashMap<>();
		dataMap.put("0", new DataNode("0", "A", null));
		dataMap.put("1", new DataNode("1", "B", "0"));
		dataMap.put("2", new DataNode("2", "C", "0"));
		dataMap.put("4", new DataNode("4", "D", "1"));
		dataMap.put("5", new DataNode("5", "E", "1"));
		dataMap.put("6", new DataNode("6", "F", "4"));
		dataMap.put("3", new DataNode("3", "G", "0"));
		//init complete
		//init root node (use for multiple root)
		String[] keySet = dataMap.keySet().toArray(new String[dataMap.keySet().size()]);
		for (String key : keySet) {
			if (dataMap.get(key).getPid() == null) {
				rootsMap.put(key, dataMap.get(key));
				if (dataMap.containsKey(key))
					dataMap.remove(key);
			}
		}
		//finish init root node
		collectChild(rootsMap);
		browseAll(rootsMap);

	}

	public static void collectChild(Map<String, DataNode> roots) {

		String[] keySet = dataMap.keySet().toArray(new String[dataMap.keySet().size()]);
		for (String key : keySet) {
			String[] keySetRoot = roots.keySet().toArray(new String[roots.keySet().size()]);
			for (String keyRoot : keySetRoot) {
				if (dataMap.isEmpty())
					break;
				//if this datanode is directly child then add to child list
				if (dataMap.get(key).getPid().equals(roots.get(keyRoot).getId())) {
					roots.get(keyRoot).getChilds().put(key, dataMap.get(key));
					dataMap.remove(key);
					break;
				} else {
					//call recursive on root child
					collectChild(roots.get(keyRoot).getChilds());
				}
			}
		}
	}

	//print all child in map
	public static void browseAll(Map<String, DataNode> data) {
		if (!data.isEmpty()) {
			for (String key : data.keySet()) {
				System.out.print(data.get(key).getId()+" ");
				if(!data.get(key).getChilds().isEmpty()){
					browseAll(data.get(key).getChilds());
				}
			}
		}
	}
}

class DataNode {
	private String id;
	private String name;
	private String pid;
	private Map<String, DataNode> childs;

	public DataNode(String id, String name, String pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		childs = new HashMap<String, DataNode>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, DataNode> getChilds() {
		return childs;
	}

	public void setChilds(Map<String, DataNode> childs) {
		this.childs = childs;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}