package utility;

import java.util.ArrayList;
import java.util.List;

public class PageSkip {
	private static int showpages = 10; //一度に表示させたいページ数はここに設定する。

	public static int[] getAllPages(List list) {
		int pages = list.size()/showpages;
		if(list.size() %showpages !=0){
			pages +=1;
		}

		int allpages[] = new int[pages];
		for(int i=0;i<pages;i++){
			allpages[i] = i+1;
		}

		return allpages;
	}

	public static List getShowpage(List list, String _page) {
		ArrayList<Object> array = new ArrayList<Object>();

		int page;
		if(_page == null){
			page = 1;
		}else{
			page = Integer.parseInt(_page);
		}

		int time = showpages*(page-1);

		for(int i=0;i<list.size();i++){
			if(i>=time){
				Object bean = (Object)list.get(i);
				array.add(bean);
			}

			if(array.size()==showpages){
				break;
			}
		}

		return array;
	}
}
