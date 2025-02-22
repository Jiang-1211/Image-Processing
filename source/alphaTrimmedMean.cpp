#include "../include/alphaTrimmedMean.h"
#include <bits/stdc++.h>
using namespace std;

int alpha(int **matrix, int length, int width, int n, int d, int k, int l)
{
    vector<int> number;
    int count = 0, value = 0;

    for (int i = k - n / 2; i <= k + n / 2; i++)
    {
        for (int j = l - n / 2; j <= l + n / 2; j++)
        {
            if (i > 0 && j > 0 && i < length && j < width)
            {
                number.push_back(matrix[i][j]);
                count++;
            }
        }
    }

    sort(number.begin(), number.end());

    for (int i = d / 2; i < count - d / 2; i++)
    {
        value += number[i];
    }

    if (count - d > 0)
    {
        value /= count - d;
    }
    else
    {
        value /= count;
    }

    return value;
}

int **getAlpha(int **matrix, int length, int width, int n, int d)
{
    int **matrixAlpha = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixAlpha[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixAlpha[i][j] = alpha(matrix, length, width, n, d, i, j);
        }
    }

    return matrixAlpha;
}