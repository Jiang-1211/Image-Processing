#include "../include/identityFilter.h"
#include <bits/stdc++.h>
using namespace std;

void identityFilter(int **matrix, int **matrixIdentityFilter, int length, int width, int n, int k, int l)
{
    // With Padding

    for (int i = k - n / 2; i <= k + n / 2; i++)
    {
        for (int j = l - n / 2; j <= l + n / 2; j++)
        {
            if (i != k || j != l)
            {
                matrixIdentityFilter[k][l] += 0;
            }
            else
            {
                matrixIdentityFilter[k][l] += matrix[i][j];
            }
        }
    }
}

int **getIdentityFilter(int **matrix, int length, int width, int n)
{
    // With Padding

    int **matrixIdentityFilter = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixIdentityFilter[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixIdentityFilter[i][j] = 0;
        }
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            identityFilter(matrix, matrixIdentityFilter, length, width, n, i, j);
        }
    }

    return matrixIdentityFilter;
}
