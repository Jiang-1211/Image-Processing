#include "./include/boxFilter.h"
#include "./include/contrastStretching.h"
#include "./include/highResolutionASCIIArt.h"
#include "./include/HistogramEqualization.h"
#include "./include/identityFilter.h"
#include "./include/inputFile.h"
#include "./include/intensityTransformation.h"
#include "./include/medianFilter.h"
#include "./include/outputFile.h"
#include "./include/alphaTrimmedMean.h"
#include "./include/laplace.h"
#include "./include/sobel.h"
#include "./include/motionBlurring.h"
#include <bits/stdc++.h>
using namespace std;

int main()
{
    while (true)
    {
        vector<string> allFile = getFileName();
        vector<string> filterName = {"Box Filter", "Identity Filter", "Median Filter", "Contrast Stretching", "Histogram Equalization", "Negative Transformation", "Log Transformation", "Gamma Transformation", "Alpha-Trimmed Mean Filter", "Laplace", "Sobel", "Motion Blurring"};
        vector<string> outputMethod = {"Output To .ppm", "Low Resolution ASCII Output To Terminal", "Low Resolution ASCII Output To .txt", "High Resolution ASCII Output To Terminal", "High Resolution ASCII Output To .txt"};
        string fileType, fileName;
        int length, width, maxValue, fileIndex, filterIndex, outputIndex, boxsize, d;
        double gamma;
        char direction;

        nameOutput(allFile, allFile.size());
        cout << "Choose a file and enter its number or enter 0 to exit : ";
        cin >> fileIndex;
        cout << "----------------------------------------" << endl;

        if (fileIndex == 0)
        {
            break;
        }
        else if (fileIndex < 0 || fileIndex > static_cast<int>(allFile.size()))
        {
            cout << "Please enter an available number!" << endl;
            continue;
        }

        ifstream input("image\\" + allFile[fileIndex - 1]);

        fileType = getType(input);
        width = getWidth(input);
        length = getLength(input);
        maxValue = getMaxValue(input);

        int **matrixInput = new int *[length];
        int **matrixOutput = new int *[length];

        for (int i = 0; i < length; i++)
        {
            matrixInput[i] = new int[width];
            matrixOutput[i] = new int[width];
        }

        getValue(input, matrixInput, length, width);

        nameOutput(filterName, filterName.size());
        cout << "Choose a filter and enter its number : ";
        cin >> filterIndex;
        cout << "----------------------------------------" << endl;

        while (filterIndex <= 0 || filterIndex > static_cast<int>(filterName.size()))
        {
            cout << "Please enter an available number!" << endl;
            nameOutput(filterName, filterName.size());
            cout << "Choose a filter and enter its number : ";
            cin >> filterIndex;
            cout << "----------------------------------------" << endl;
        }

        switch (filterIndex)
        {
        case 1:
            cout << "Enter box size n (nxn) : ";
            cin >> boxsize;
            cout << "----------------------------------------" << endl;
            while (boxsize <= 0)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter box size n (nxn) : ";
                cin >> boxsize;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getBoxFilter(matrixInput, length, width, boxsize);
            break;
        case 2:
            cout << "Enter box size n (nxn) : ";
            cin >> boxsize;
            cout << "----------------------------------------" << endl;
            while (boxsize <= 0)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter box size n (nxn) : ";
                cin >> boxsize;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getIdentityFilter(matrixInput, length, width, boxsize);
            break;
        case 3:
            cout << "Enter box size n (nxn) : ";
            cin >> boxsize;
            cout << "----------------------------------------" << endl;
            while (boxsize <= 0)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter box size n (nxn) : ";
                cin >> boxsize;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getMedianFilter(matrixInput, length, width, boxsize);
            break;
        case 4:
            matrixOutput = getContrastStretching(matrixInput, length, width);
            break;
        case 5:
            matrixOutput = getHistogram(matrixInput, length, width);
            break;
        case 6:
            matrixOutput = getNegativeTransformation(matrixInput, length, width, maxValue);
            break;
        case 7:
            matrixOutput = getLogTransformation(matrixInput, length, width, 50);
            break;
        case 8:
            cout << "Enter gamma value (a positive number) : ";
            cin >> gamma;
            cout << "----------------------------------------" << endl;
            while (gamma <= 0)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter gamma value (a positive number) : ";
                cin >> gamma;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getGammaTransformation(matrixInput, length, width, 1, gamma);
            break;
        case 9:
            cout << "Enter the total number n of pixels in the window (nxn) : ";
            cin >> boxsize;
            cout << "----------------------------------------" << endl;
            while (boxsize < 1)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter the total number n of pixels in the window (nxn) : ";
                cin >> boxsize;
                cout << "----------------------------------------" << endl;
            }
            cout << "Enter the number d of pixels to be removed : ";
            cin >> d;
            cout << "----------------------------------------" << endl;
            while (d < 0 || d >= boxsize * boxsize)
            {
                cout << "Enter the number d of pixels to be removed : ";
                cin >> d;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getAlpha(matrixInput, length, width, boxsize, d);
            break;
        case 10:
            matrixOutput = getLaplace(matrixInput, length, width);
            break;
        case 11:
            matrixOutput = getSobel(matrixInput, length, width);
            break;
        case 12:
            cout << "Enter box size n : ";
            cin >> boxsize;
            cout << "----------------------------------------" << endl;
            while (boxsize <= 0)
            {
                cout << "Please enter an available number!" << endl;
                cout << "Enter box size n (nxn) : ";
                cin >> boxsize;
                cout << "----------------------------------------" << endl;
            }
            cout << "Enter the direction x or y : ";
            cin >> direction;
            cout << "----------------------------------------" << endl;
            while (toupper(direction) != 'X' && toupper(direction) != 'Y')
            {
                cout << "Please enter an available direction!" << endl;
                cout << "Enter direction X or Y : ";
                cin >> direction;
                cout << "----------------------------------------" << endl;
            }
            matrixOutput = getMotionBlurring(matrixInput, length, width, boxsize, direction);
            break;
        default:
            break;
        }

        nameOutput(outputMethod, outputMethod.size());
        cout << "Choose a way to output and enter its number : ";
        cin >> outputIndex;
        cout << "----------------------------------------" << endl;
        while (outputIndex <= 0 || outputIndex > static_cast<int>(outputMethod.size()))
        {
            cout << "Please enter an available number!" << endl;
            nameOutput(outputMethod, outputMethod.size());
            cout << "Choose a way to output and enter its number : ";
            cin >> outputIndex;
            cout << "----------------------------------------" << endl;
        }

        switch (outputIndex)
        {
        case 1:
            cout << "Enter file name : ";
            cin >> fileName;
            cout << "----------------------------------------" << endl;
            fileOutput(matrixOutput, length, width, fileName);
            break;
        case 2:
            ASCIIOutput(matrixOutput, length, width);
            break;
        case 3:
            cout << "Enter file name : ";
            cin >> fileName;
            cout << "----------------------------------------" << endl;
            ASCIIFileOutput(matrixOutput, length, width, fileName);
            break;
        case 4:
            highResolutionOutput(matrixOutput, length, width);
            break;
        case 5:
            cout << "Enter file name : ";
            cin >> fileName;
            cout << "----------------------------------------" << endl;
            highResolutionFileOutput(matrixOutput, length, width, fileName);
            break;
        default:
            break;
        }

        for (int i = 0; i < length; i++)
        {
            delete[] matrixInput[i];
            delete[] matrixOutput[i];
        }
        delete[] matrixInput;
        delete[] matrixOutput;

        input.close();
    }

    cout << "Press Enter to exit...";
    cin.ignore();
    cin.get();

    return 0;
}