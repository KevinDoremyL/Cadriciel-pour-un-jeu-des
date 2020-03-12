public class De implements Comparable<De> {
    private int nbFaces;

    public De(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public void setFaceObtenue(int faceObtenue) {
        this.nbFaces = faceObtenue;
    }
    public void roll()
    {
        this.nbFaces = (int)(Math.random() * nbFaces) + 1;


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
        return nbFaces;
    }
}