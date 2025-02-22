#ifndef _INTENSITYTRANSFORMATION_H_
#define _INTENSITYTRANSFORMATION_H_
#include <bits/stdc++.h>
using namespace std;

int **getNegativeTransformation(int **matrix, int length, int width, int maxValue);

int **getLogTransformation(int **matrix, int length, int width, int c);

int **getGammaTransformation(int **matrix, int length, int width, int c, double gamma);

#endif