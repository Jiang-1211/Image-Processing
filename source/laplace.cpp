#include "../include/laplace.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

void laplace(int **matrix, int **matrixLaplace, int length, int width, int k, int l)
{
    int laplace[3][3] = {{0, 1, 0}, {1, -4, 1}, {0, 1, 0}}, sum = 0;

    for (int i = k - 1; i <= k + 1; i++)
    {
        for (int j = l - 1; j <= l + 1; j++)
        {
            if (i < 0 || j < 0 || i >= length || j >= width)
            {
                sum += 0;
            }
            else
            {
                sum = sum + matrix[i][j] * laplace[i - k + 1][j - l + 1];
            }
        }
    }

    matrixLaplace[k][l] = matrix[k][l] - sum;

    if (matrixLaplace[k][l] > MAX_PIXEL)
    {
        matrixLaplace[k][l] = MAX_PIXEL;
    }
    else if (matrixLaplace[k][l] < 0)
    {
        matrixLaplace[k][l] = 0;
    }
}

int **getLaplace(int **matrix, int length, int width)
{
    int **matrixLaplace = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixLaplace[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            laplace(matrix, matrixLaplace, length, width, i, j);
        }
    }

    return matrixLaplace;
}