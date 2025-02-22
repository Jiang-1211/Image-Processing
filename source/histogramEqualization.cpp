#include "../include/histogramEqualization.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

void countPossibility(int **matrix, int *possibility, int length, int width)
{
    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            possibility[matrix[i][j]]++;
        }
    }

    for (int i = 0; i < MAX_PIXEL - 1; i++)
    {
        possibility[i + 1] += possibility[i];
    }
}

int **getHistogram(int **matrix, int length, int width)
{
    int possibility[MAX_PIXEL + 1] = {0};

    int **matrixHistogram = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixHistogram[i] = new int[width];
    }

    countPossibility(matrix, possibility, length, width);

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixHistogram[i][j] = (MAX_PIXEL * possibility[matrix[i][j]]) / (length * width);
        }
    }

    return matrixHistogram;
}