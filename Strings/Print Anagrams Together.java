public List<List<String>> Anagrams(String[] string_list) {
    // Code here

    HashMap<String,List<String>> hm=new HashMap<>();
    List<List<String>> list= new ArrayList<>();
    for(String s:string_list){
    
        char arr[]= s.toCharArray();
        Arrays.sort(arr);
        String key= new String(arr);
        if(hm.containsKey(key)){
            List<String> l= hm.get(key);
            l.add(s);
            hm.put(key,l);
        }else{
            List<String> l = new ArrayList<>();
            
            l.add(s);
            hm.put(key,l);
        }
    }
    for(String a:hm.keySet()){
        list.add(hm.get(a));
    }
    return list;
}