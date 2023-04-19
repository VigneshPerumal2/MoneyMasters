/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directories;

import model.User;

import java.util.ArrayList;


public class UserDirectory {

    private ArrayList<User> history;

    public UserDirectory() {
        this.history = new ArrayList<User>();

    }

    public ArrayList<User> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<User> history) {
        this.history = history;
    }

    public User addNewUser(User user){
        System.out.println("User Added->"+user);
        history.add(user);
        return user;
    }

    public void deleteUser(int index){
        history.remove(index);
    }

    public void updateUser(User user,int index){
        history.set(index,user);
    }
    public void deleteAll(){
        history.removeAll(history);
    }

    public boolean login(String emailId, String password){
        for(User user: history){
            if(user.getEmailId().equals(emailId) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "UserDirectory{" + "history=" + history + '}';
    }

}
