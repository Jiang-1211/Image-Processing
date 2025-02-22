#include "../include/motionBlurring.h"
#include <bits/stdc++.h>
using namespace std;

void motionBlurring_x(int **matrix, int **matrixBlurring, int length, int width, int n, int k, int l)
{
    int sum = 0;

    for (int i = l - n / 2; i < l + n / 2; i++)
    {
        if (i < 0 || i >= width)
        {
            sum += 0;
        }
        else
        {
            sum += matrix[k][i];
        }
    }

    matrixBlurring[k][l] = sum / n;
}

void motionBlurring_y(int **matrix, int **matrixBlurring, int length, int width, int n, int k, int l)
{
    int sum = 0;

    for (int i = k - n / 2; i < k + n / 2; i++)
    {
        if (i < 0 || i >= length)
        {
            sum += 0;
        }
        else
        {
            sum += matrix[i][l];
        }
    }

    matrixBlurring[k][l] = sum / n;
}

int **getMotionBlurring(int **matrix, int length, int width, int n, char direction)
{
    int **matrixBlurring = new int *[length];

    for (int i = 0; i < length; i++)
    {
        matrixBlurring[i] = new int[width];
    }

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (direction == 'x' || direction == 'X')
            {
                motionBlurring_x(matrix, matrixBlurring, length, width, n, i, j);
            }
            else if (direction == 'y' || direction == 'Y')
            {
                motionBlurring_y(matrix, matrixBlurring, length, width, n, i, j);
            }
        }
    }

    return matrixBlurring;
}