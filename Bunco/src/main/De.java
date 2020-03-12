
public class De implements Comparable<De> {
    private int nbFaces;

    public De(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public void setFaceObtenue(int faceObtenue) {
        this.nbFaces = faceObtenue;
    }

    public int roll() {
        this.nbFaces = (int) (Math.random() * nbFaces) + 1;

        return this.nbFaces;
    }

    @Override
    public int compareTo(De o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        String result = Integer.toString(this.nbFaces);
        return result;
    }

}