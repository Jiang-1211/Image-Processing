#include "../include/boxFilter.h"
#include <bits/stdc++.h>
using namespace std;

void boxFilter(int **matrix, int **matrixBoxFilter, int length, int width, int n, int k, int l)
{
    for (int i = k - n / 2; i <= k + n / 2; i++)
    {
        for (int j = l - n / 2; j <= l + n / 2; j++)
        {
            if (i < 0 || j < 0 || i >= length || j >= width)
            {
                matrixBoxFilter[k][l] += 0;
            }
            else
            {
                matrixBoxFilter[k][l] += matrix[i][j];
            }
        }
    }

    matrixBoxFilter[k][l] /= n * n;
}

int **getBoxFilter(int **matrix, int length, int width, int n)
{
    int **matrixBoxFilter = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixBoxFilter[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixBoxFilter[i][j] = 0;
        }
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            boxFilter(matrix, matrixBoxFilter, length, width, n, i, j);
        }
    }

    return matrixBoxFilter;
}