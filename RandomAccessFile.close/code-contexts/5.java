/**
 * Source: https://github.com/craigpetchell/Jaudiotagger/blob/master/src/org/jaudiotagger/audio/flac/FlacInfoReader.java
 */
public int countMetaBlocks(File f) throws CannotReadException, IOException
{
        RandomAccessFile raf = new RandomAccessFile(f, "r");
        FlacStreamReader flacStream = new FlacStreamReader(raf);
        flacStream.findStream();


        boolean isLastBlock = false;

        int count = 0;
        while (!isLastBlock)
        {
            MetadataBlockHeader mbh = MetadataBlockHeader.readHeader(raf);
            logger.config("Found block:" + mbh.getBlockType());
            raf.seek(raf.getFilePointer() + mbh.getDataLength());
            isLastBlock = mbh.isLastBlock();
            mbh = null; //Free memory
            count++;
        }
        raf.close();
        return count;
}
