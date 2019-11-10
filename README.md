# RNA-Folding-Algorithm-using-Dynamic-Programming
 A nucleotide base pair brings two bases physically together, contributing to the structure into which an RNA molecule may form. The maximization of such base pairs corresponds to the minimization of free energy that may stabilize the formed structure. 

## Introduction

This project is to compute the maximum number of permissible letter pairs
from the input sequence of 4 letters (A, C, G, U). For these letters, legal
pairs are A-U, U-A, G-C, C-G while others (such a G-A) are illegal. In
addition, a pairing between two letters is exclusive, e.g., if a letter U on the
sequence that is paired with a letter A, that letter U cannot be paired with
another letter A. This problem is called Structure Prediction because it is
a meaningful abstraction of the significant problem RNA secondary structure
prediction in computational biology, where A, C, G, and U are nucleotide
bases that constitute RNA sequences

### Input
Input data to this program are in a plain text file, named sequence.txt.
It contains an RNA sequence in the format:
'''
> name of the sequence
'''
'''
AUGUCAGCGUU
'''

### Output

The output issaved to a plain text file and should contain the maximum count of base pairs and the input sequence underlined with denotational symbols {, } and dot ’.’, in the format:
'''
> AUGUCAGCGUU

{{{.}}.{}.}

>max count of pairs

4

'''
