/*
 * LeetCode の VersionControl クラスを模倣したクラス。
 * 指定されたバージョンが不正（bad）かどうかを判定する APIを提供
 */
public class VersionControl {
    /*
     * コンストラクタ
     * @param bad 最初のbad version
     */
    private final int bad;
    public VersionControl(int bad) {
        this.bad = bad;
    }
    /*
     * 指定したバージョンがbadか判定する
     * @param version 判定対象のバージョン番号
     * @return batの場合true　goodの場合はfalse
     */
    boolean isBadVersion(int version) {
        return version >= bad;
    }
}
