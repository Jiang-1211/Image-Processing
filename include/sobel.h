#ifndef _SOBAL_H_
#define _SOBAL_H_
#include <bits/stdc++.h>
using namespace std;

void sobel(int **matrix, int **matrixLaplace, int length, int width, int k, int l);

int **getSobel(int **matrix, int length, int width);

#endif