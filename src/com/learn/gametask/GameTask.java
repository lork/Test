package com.learn.gametask;

import java.util.Scanner;

public class GameTask
{
    public static void main(String[] args)
    {
        int[] a = new int[32];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            int id1 = scanner.nextInt() - 1;
            int id2 = scanner.nextInt() - 1;
            System.out.println(result(id1, id2, a));
        }
    }

    private static int result(int id1, int id2, int[] a)
    {
        if (id1 < 0 || id1 >= 1024 || id2 < 0 || id2 >= 1024)
        {
            return -1;
        }

        int groupId = id1 / 32;
        int index = id1 % 32;

        int value = 1 << index;
        if ((value & a[index]) == 0)
        {
            a[groupId] += value;
        }

        groupId = id2 / 32;
        index = id2 % 32;
        value = 1 << index;

        if ((value & a[groupId]) == 0)
        {
            return 0;
        }
        return 1;
    }
}
