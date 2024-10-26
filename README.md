# Huffman Encoding

This project implements the Huffman Encoding algorithm in Java. Huffman Encoding is a compression algorithm used to reduce the size of text files. The algorithm builds a binary tree based on the frequency of characters in the input text and generates variable-length codes for each character, allowing for efficient encoding and decoding.

## Features

- **Frequency Calculation**: Computes the frequency of each character in the input text.
- **Huffman Tree Construction**: Builds a Huffman tree based on character frequencies.
- **Encoding**: Generates Huffman codes for each character.
- **Decoding**: Provides a method to retrieve the original text from the encoded string.
- **Compression Statistics**: Displays the size of the original and encoded strings.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Installation

1. Clone the repository or download the source code.
2. Open the project in your preferred IDE.
3. Compile the Java file.

### Usage

1. Run the `HuffmanEncoding` class.
2. Input the string you want to encode when prompted.
3. The program will display:
    - The Huffman codes for each character.
    - The original string.
    - The encoded string.
    - The initial size of the string in bits.
    - The size of the compressed string in bits.

### Example

```plaintext
Enter the String you wanted to convert:
hello world

Huffman Code of the Characters are : 
{d=000, r=001, w=010, h=0110, o=0111, 
l=100, e=101, =110, 0=111}

The Initial text: hello world

The Encoded String:
 011001001101011110100001000
The Decoded String is: hello world

The initial size of the string is = 88
That String compressed to = 30
