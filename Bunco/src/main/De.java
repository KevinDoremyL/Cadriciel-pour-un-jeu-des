package src.main;

public class De implements Comparable<De> {
    int nbFaces;

    public De() {

    }

    public De(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public void setFaceObtenue(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int getFaceObtenue() {
        return nbFaces;
    }
    @Override
    public int compareTo(De o) {
        // TODO Auto-generated method stub
        return 0;
    }
}