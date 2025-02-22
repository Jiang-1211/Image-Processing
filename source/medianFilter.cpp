#include "../include/boxFilter.h"
#include <bits/stdc++.h>
#include <fstream>
using namespace std;

void medianFilter(int **matrix, int **matrixMedianFilter, int length, int width, int n, int k, int l)
{
    // Without Padding

    int pixelValueSort[n * n];
    int pixelCount = 0;

    for (int i = k - n / 2; i <= k + n / 2; i++)
    {
        for (int j = l - n / 2; j <= l + n / 2; j++)
        {
            pixelValueSort[pixelCount] = matrix[i][j];
            pixelCount++;
        }
    }

    for (int i = 0; i < pixelCount; i++)
    {
        for (int j = i + 1; j < pixelCount; j++)
        {
            if (pixelValueSort[i] < pixelValueSort[j])
            {
                int changeValue = pixelValueSort[i];
                pixelValueSort[i] = pixelValueSort[j];
                pixelValueSort[j] = changeValue;
            }
        }
    }

    if (pixelCount % 2 == 1)
    {
        matrixMedianFilter[k][l] = pixelValueSort[(pixelCount + 1) / 2 - 1];
    }
    else
    {
        matrixMedianFilter[k][l] = (pixelValueSort[pixelCount / 2 - 1] + pixelValueSort[pixelCount / 2 + 1 - 1]) / 2;
    }
}

int **getMedianFilter(int **matrix, int length, int width, int n)
{
    // Without Padding

    int **matrixMedianFilter = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixMedianFilter[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            matrixMedianFilter[i][j] = 0;
        }
    }

    for (int i = n / 2; i < length - n / 2; i++)
    {
        for (int j = n / 2; j < width - n / 2; j++)
        {
            medianFilter(matrix, matrixMedianFilter, length, width, n, i, j);
        }
    }

    return matrixMedianFilter;
}
