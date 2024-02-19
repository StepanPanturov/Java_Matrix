public class ComplexNumber {
    private int real, imag;
    public ComplexNumber(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber sub(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    public ComplexNumber mult(ComplexNumber other) {
        int multReal = this.real * other.real - this.imag * other.imag;
        int multImag = this.real * other.imag + other.real * this.imag;
        return new ComplexNumber(multReal, multImag);
    }

    public void print_elem() {
        if (real == 0 && imag == 0) {
            System.out.print(0);
        }
        else if (real == 0) {
            if (imag == 1) {
                System.out.print("i");
            }
            else if (imag == -1) {
                System.out.print("-i");
            }
            else System.out.print(imag + "i");
        }
        else {
            if (imag < 0) {
                if (imag == -1) {
                    System.out.print(real + " - i");
                }
                else System.out.print(real + " - " + (-imag) + "i");
            }
            else if (imag == 0) {
                System.out.print(real);
            }
            else if (imag == 1) {
                System.out.print(real + " + i");
            }
            else System.out.print(real + " + " + imag + "i");
        }
    }
}
