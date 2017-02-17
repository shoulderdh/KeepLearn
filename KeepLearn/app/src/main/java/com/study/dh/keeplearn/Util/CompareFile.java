package com.study.dh.keeplearn.Util;

import java.util.List;

/**
 * Created by dh on 2017/2/16.
 */

public class CompareFile {

    public  List<String> CompareFile(List<String> strings,List<String> strings2) {
            if (strings.size()>0&&strings2.size()>0){
                  for (int i=0;i<strings2.size();i++){
                       for (int j=0;j<strings.size();j++){
                           if (strings.get(j)==strings2.get(i)){
                               strings.remove(j);
                           }

                       }
                  }
            }
        return  strings;

    }
}
