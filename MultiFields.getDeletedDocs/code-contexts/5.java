/**
 * Source: https://github.com/ieure/lucene-solr-snapshot/blob/master/lucene/src/test/org/apache/lucene/analysis/TestCachingTokenFilter.java
 */ 
public void testCaching() throws IOException {
    
	  ...
    
    IndexReader reader = writer.getReader();
    DocsAndPositionsEnum termPositions = MultiFields.getTermPositionsEnum(reader,
                                                                          MultiFields.getDeletedDocs(reader),
                                                                          "preanalyzed",
                                                                          new BytesRef("term1"));
    assertTrue(termPositions.nextDoc() != termPositions.NO_MORE_DOCS);
    assertEquals(1, termPositions.freq());
    assertEquals(0, termPositions.nextPosition());

    termPositions = MultiFields.getTermPositionsEnum(reader,
                                                     MultiFields.getDeletedDocs(reader),
                                                     "preanalyzed",
                                                     new BytesRef("term2"));
    assertTrue(termPositions.nextDoc() != termPositions.NO_MORE_DOCS);
    assertEquals(2, termPositions.freq());
    assertEquals(1, termPositions.nextPosition());
    assertEquals(3, termPositions.nextPosition());
    
    ... 
}
