/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directories;

import model.Transaction;
import model.User;

import java.util.ArrayList;


public class TransactionDirectory {

    private ArrayList<Transaction> history;

    public TransactionDirectory() {
        this.history = new ArrayList<Transaction>();

    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Transaction> history) {
        this.history = history;
    }

    public Transaction addNewTransaction(Transaction transaction){
        history.add(transaction);
        return transaction;
    }

    public void deleteTransaction(int index){
        history.remove(index);
    }

    public void updateTransaction(Transaction transaction,int index){
        history.set(index,transaction);
    }
    public void deleteAll(){
        history.removeAll(history);
    }

    @Override
    public String toString() {
        return "TransactionDirectory{" + "history=" + history + '}';
    }

}
