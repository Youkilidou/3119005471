package util;


public class Fraction {
    private int numerator;  // ����
    private int denominator; // ��ĸ
    private Integer integer;


    public Fraction() {
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public Fraction(int a, int b) {
        if (a == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            setNumeratorAndDenominator(a, b);
        }
    }

    private void setNumeratorAndDenominator(int a, int b) {  // ���÷��Ӻͷ�ĸ
        int c = f(Math.abs(a), Math.abs(b));         // �������Լ��
        numerator = a / c;
        denominator = b / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int f(int a, int b) {  // ��a��b�����Լ��
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            ;
            r = a % b;
        }
        return b;
    }

    public Fraction add(Fraction r) {  // �ӷ�����
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
            result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction sub(Fraction r) {  // ��������
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction muti(Fraction r) { // �˷�����
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction div(Fraction r) {  // ��������
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    @Override
    public String toString() {
        if(integer==null)
            return numerator+"/"+denominator;

        return integer+"'"+numerator+"/"+denominator;
    }


}