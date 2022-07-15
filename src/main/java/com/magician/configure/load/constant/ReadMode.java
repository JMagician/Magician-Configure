package com.magician.configure.load.constant;

/**
 * Mode of reading configuration files
 *
 * LOCAL: Read from the resource directory
 * EXTERNAL: Read from any directory on the local machine
 * REMOTE: Read remote via http
 */
public enum ReadMode {

    LOCAL, EXTERNAL, REMOTE
}
