/**
 * Source: https://github.com/ieure/lucene-solr-snapshot/blob/master/lucene/contrib/instantiated/src/test/org/apache/lucene/store/instantiated/TestIndicesEquals.java
 */
private void testTermDocsSomeMore(Directory aprioriIndex, InstantiatedIndex testIndex) throws Exception {

    IndexReader aprioriReader = IndexReader.open(aprioriIndex, false);
    IndexReader testReader = testIndex.indexReaderFactory();

    Term t = new Term("c", "danny");
    TermsEnum aprioriTermEnum = MultiFields.getTerms(aprioriReader, t.field()).iterator();
    aprioriTermEnum.seek(new BytesRef(t.text()));
    TermsEnum testTermEnum = MultiFields.getTerms(testReader, t.field()).iterator();
    testTermEnum.seek(new BytesRef(t.text()));
    assertEquals(aprioriTermEnum.term(), testTermEnum.term());
	
	...

    DocsEnum aprioriTermDocs = aprioriTermEnum.docs(MultiFields.getDeletedDocs(aprioriReader), null);
    DocsEnum testTermDocs = testTermEnum.docs(MultiFields.getDeletedDocs(testReader), null);

    assertEquals(aprioriTermDocs.nextDoc(), testTermDocs.nextDoc());
    assertEquals(aprioriTermDocs.freq(), testTermDocs.freq());

    // clean up
    aprioriReader.close();
    testReader.close();
}
