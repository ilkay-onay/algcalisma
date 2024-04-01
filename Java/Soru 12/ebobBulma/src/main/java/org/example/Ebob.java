package org.example;

public class Ebob {

        public static int ebob(int n1, int n2)
        {
            if (n2 != 0)
                return ebob(n2, n1 % n2);
            else
                return n1;
        }
    }
