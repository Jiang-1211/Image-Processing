#include "../include/intensityTransformation.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

int **getNegativeTransformation(int **matrix, int length, int width, int maxValue)
{
    int **matrixNegative = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixNegative[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixNegative[i][j] = maxValue - matrix[i][j];
        }
    }

    return matrixNegative;
}

int **getLogTransformation(int **matrix, int length, int width, int c)
{
    int **matrixLog = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixLog[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixLog[i][j] = c * log(1 + matrix[i][j]);
        }
    }

    return matrixLog;
}

int **getGammaTransformation(int **matrix, int length, int width, int c, double gamma)
{
    int **matrixGamma = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixGamma[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixGamma[i][j] = MAX_PIXEL * c * pow(static_cast<double>(matrix[i][j]) / MAX_PIXEL, gamma);
        }
    }

    return matrixGamma;
}