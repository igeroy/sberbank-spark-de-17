import com.fasterxml.jackson.annotation.JsonProperty;

public class HistResults {

    @JsonProperty(value = "hist_film")
    int[] histFilm = new int[]{0, 0, 0, 0, 0};
    @JsonProperty(value = "hist_all")
    int[] histAll = new int[]{0, 0, 0, 0, 0};

    public int[] getHistFilm() {
        return histFilm;
    }

    public void setHistFilm(int[] histFilm) {
        this.histFilm = histFilm;
    }

    public int[] getHistAll() {
        return histAll;
    }

    public void setHistAll(int[] histAll) {
        this.histAll = histAll;
    }
}
