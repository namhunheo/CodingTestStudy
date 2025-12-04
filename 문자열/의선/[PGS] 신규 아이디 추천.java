class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        
        //1단계 소문자 치환
        new_id = new_id.toLowerCase();
        
        System.out.println(new_id);
        //2단계 제거
        
        String temp = new_id;
        
        for(int i=0;i<temp.length();i++){
            char a = temp.charAt(i);
            if(a>='a'&&a<='z'){
                
            }else if(a>='0'&&a<='9'){
                
            }else if(a=='-'){
                
            }else if(a=='_'){
                
            }else if(a=='.'){
                
            }else{
                new_id = new_id.replace(a+"","");
            }
        }
        System.out.println(new_id);
        //3단계 .. 연속 하나 제거
        while(true){
            new_id = new_id.replace("..",".");
            
            if(new_id.indexOf("..")==-1){
                break;
            }
        }
        System.out.println(new_id);
        
        //4단계 양끝 . 이면 지우기
        if(new_id.length()==0||new_id.length()==1){
            if(new_id.equals(".")){
                new_id="";
            }
        }else{
        
        
        
            char first = new_id.charAt(0);
            if(first=='.'){
                new_id = new_id.substring(1);
            }
            char end = new_id.charAt(new_id.length()-1);
            if(end=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        System.out.println(new_id);
        //5단계
        if(new_id.equals("")){
            new_id += "a";
        }
        System.out.println(new_id);
        
        //6단계
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            
            char end = new_id.charAt(new_id.length()-1);
            if(end=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
            
        }
        
        //7단계
         while (new_id.length() < 3) {
        new_id += new_id.substring(new_id.length()-1);
        }
        
        
        
        
        return new_id;
    }
}