#ifndef _OUTPUTFILE_H_
#define _OUTPUTFILE_H_
#include <bits/stdc++.h>
using namespace std;

void nameOutput(vector<string> &inputVec, int size);

void fileOutput(int **matrix, int length, int width, string fileName);

void ASCIIOutput(int **matrix, int length, int width);

void ASCIIFileOutput(int **matrix, int length, int width, string fileName);

#endif