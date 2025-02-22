#ifndef _MOTIONBLURRING_H_
#define _MOTIONBLURRING_H_
#include <bits/stdc++.h>
using namespace std;

void motionBlurring_x(int **matrix, int **matrixBlurring, int length, int width, int n, int k, int l);

void motionBlurring_y(int **matrix, int **matrixBlurring, int length, int width, int n, int k, int l);

int **getMotionBlurring(int **matrix, int length, int width, int boxsize, char direction);

#endif