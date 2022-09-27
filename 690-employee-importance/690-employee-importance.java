/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emap = new HashMap<>();
        
        for(Employee emp : employees){
            emap.put(emp.id, emp);
        }
        
        Queue<Employee> q = new LinkedList<>();
        q.add(emap.get(id));
        
        int imp = 0;
        while(!q.isEmpty()){
            Employee  emp = q.poll();
            imp += emp.importance;
            
            //adding direct subordinates in the queue
            for(int subId : emp.subordinates){
                q.add(emap.get(subId));
            }
        }
        
        return imp;
    }
}