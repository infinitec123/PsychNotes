package infinite.loop.psychnotes.common;


public class Utils {

    /**
     * Returns <code>true</code> if string is not null and not empty.
     *
     * @param s
     * @return
     */
    public static boolean isNonNullAndNonEmpty(final String s) {
        boolean returnValue = true;
        if (s == null) {
            returnValue = false;
        }
        if (s != null && s.trim().length() <= 0) {
            returnValue = false;
        }
        return returnValue;
    }
}
