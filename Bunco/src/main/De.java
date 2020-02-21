public class De implements Comparable {
    int face;

    public De() {

    }

    public De(int face) {
        this.face = face;
    }

    public void setFaceObtenue(int face) {
        this.face = face;
    }

    public int compareTo(De de) {
        return 1;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}