#ifndef _BOXFILTER_H_
#define _BOXFILTER_H_
#include <bits/stdc++.h>
using namespace std;

void boxFilter(int **matrix, int **matrixBoxFilter, int length, int width, int n, int k, int l);

int **getBoxFilter(int **matrix, int length, int width, int n);

#endif