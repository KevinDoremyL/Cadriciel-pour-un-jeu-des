public class De implements Comparable<De> {
    private int nbFaces;
    private int numéroDé;
    public De(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public void setFaceObtenue(int faceObtenue) {
        this.numéroDé = faceObtenue;
    }
    public void roll()
    {
        this.numéroDé = (int)(Math.random() * nbFaces) + 1;


    }
    @Override
    public int compareTo(De o) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public String toString()
    {
        String result = Integer.toString(this.nbFaces);
        return result;
    }

    public int getNbFaces() {
        return numéroDé;
    }
}