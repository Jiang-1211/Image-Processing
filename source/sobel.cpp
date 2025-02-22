#include "../include/sobel.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

void sobel(int **matrix, int **matrixSobel, int length, int width, int k, int l)
{
    int sobel_x[3][3] = {{1, 0, -1}, {2, 0, -2}, {1, 0, -1}};
    int sobel_y[3][3] = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
    int sum_x = 0, sum_y = 0, gradient = 0;

    for (int i = k - 1; i <= k + 1; i++)
    {
        for (int j = l - 1; j <= l + 1; j++)
        {
            if (i < 0 || j < 0 || i >= length || j >= width)
            {
                sum_x += 0;
                sum_y += 0;
            }
            else
            {
                sum_x += matrix[i][j] * sobel_x[i - k + 1][j - l + 1];
                sum_y += matrix[i][j] * sobel_y[i - k + 1][j - l + 1];
            }
        }
    }
    gradient = sqrt(pow(sum_x, 2) + pow(sum_y, 2));

    matrixSobel[k][l] = matrix[k][l] - 0.25 * gradient;

    if (matrixSobel[k][l] > MAX_PIXEL)
    {
        matrixSobel[k][l] = MAX_PIXEL;
    }
}

int **getSobel(int **matrix, int length, int width)
{
    int **matrixSobel = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixSobel[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            sobel(matrix, matrixSobel, length, width, i, j);
        }
    }

    return matrixSobel;
}