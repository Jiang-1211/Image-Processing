#include "../include/contrastStretching.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

int getMinimun(int **matrix, int length, int width)
{
    int min = 255;

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (matrix[i][j] < min)
            {
                min = matrix[i][j];
            }
        }
    }

    return min;
}

int getMaximun(int **matrix, int length, int width)
{
    int max = 0;

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (matrix[i][j] > max)
            {
                max = matrix[i][j];
            }
        }
    }

    return max;
}

int **getContrastStretching(int **matrix, int length, int width)
{
    int min = getMinimun(matrix, length, width), max = getMaximun(matrix, length, width);

    int **matrixStretching = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixStretching[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixStretching[i][j] = MAX_PIXEL * (matrix[i][j] - min) / (max - min);
        }
    }

    return matrixStretching;
}