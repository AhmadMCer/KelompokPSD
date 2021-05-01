package com.kelompokpsd.stack;

/*
Code was Writen by Kelompok 7
    Afifatunni'mah          20104007
    Ahmad Nawawi            20104009
    Amita Putry Prasasti	20104014
    Raihan Febriyansah      20104102
*/

import java.util.Scanner;
public class InfixToPosfix {
    public Object data;
    public InfixToPosfix next;
    //Method untuk Konversi Infix ke Postfix
    public InfixToPosfix(Object val) {
        data = val;
        next = null;
    }
    //Class inPost
    public static class inPost {
        private InfixToPosfix top;
        //Method inPost
        public inPost(){
            top = null;
        }
        //Method Empty
        public boolean empty() {
            return top != null;
        }
        //Method Push
        public void push(Object e) {
            InfixToPosfix temp = new InfixToPosfix(e);
            temp.next = top;
            top = temp;
        }
        //Method Pop
        public Object pop() {
            Object e = top.data;
            top = top.next;
            return  e;
        }
        //Method Peek
        public Object peek() {
            Object e = top.data;
            return e;
        }
        //Method Postfix
        public void postfix(String n) {
            StringBuilder output = new StringBuilder("");
            inPost value = new inPost();
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);
                if (c == ('+') || c == ('*') || c == ('-') || c == ('/')) {
                    while (value.empty() && priority(value.peek()) >= priority(c))
                        output.append(value.pop());
                    value.push(c);
                } else if (c == '(') {
                    value.push(c);
                } else if (c == ')') {
                    while (!value.peek().equals('('))
                        output.append(value.pop());
                    value.pop();
                } else
                    output.append(c);
            }
            while (value.empty())
                output.append(value.pop());
            System.out.println("Notasi Infix\t: " + n);
            System.out.println("Notasi Postfix\t: " + output);
        }
        //Method Priority
        public int priority(Object n) {
            if (n.equals('+') || n.equals('-'))
                return 1;
            else if (n.equals('*') || n.equals('/'))
                return 2;
            else
                return 0;
        }
        //Method Main
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            inPost post = new inPost();
            System.out.println("------------------------------------------");
            System.out.print("Inputkan Notasi Infix\t: ");
            String input = in.nextLine();
            System.out.println("------------------------------------------");
            post.postfix(input);
            System.out.println("------------------------------------------");
        }
    }
}
