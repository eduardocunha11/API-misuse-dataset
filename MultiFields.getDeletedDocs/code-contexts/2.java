/**
 * Source: https://github.com/ieure/lucene-solr-snapshot/blob/master/lucene/src/test/org/apache/lucene/search/TestPositionIncrement.java
 */

public void testSetPosition() throws Exception {

	  ...
    
    IndexSearcher searcher = newSearcher(reader);
    DocsAndPositionsEnum pos = MultiFields.getTermPositionsEnum(searcher.getIndexReader(),
                                                                MultiFields.getDeletedDocs(searcher.getIndexReader()),
                                                                "field",
                                                                new BytesRef("1"));
    pos.nextDoc();
    // first token should be at position 0
    assertEquals(0, pos.nextPosition());
    pos = MultiFields.getTermPositionsEnum(searcher.getIndexReader(),
                                           MultiFields.getDeletedDocs(searcher.getIndexReader()),
                                           "field",
                                           new BytesRef("2"));
    pos.nextDoc();
    // second token should be at position 2
    assertEquals(2, pos.nextPosition());
    
	  ...
    
    searcher.close();
    reader.close();
    store.close();
}
