/**
 * Source: https://github.com/ieure/lucene-solr-snapshot/blob/master/lucene/contrib/queries/src/test/org/apache/lucene/search/DuplicateFilterTest.java
 */ 
public void testKeepsLastFilter() throws Throwable
{
		DuplicateFilter df=new DuplicateFilter(KEY_FIELD);
		df.setKeepMode(DuplicateFilter.KM_USE_LAST_OCCURRENCE);
		ScoreDoc[] hits = searcher.search(tq,df, 1000).scoreDocs;
		assertTrue("Filtered searching should have found some matches",hits.length>0);
		for(int i=0;i<hits.length;i++)
		{
			Document d=searcher.doc(hits[i].doc);
			String url=d.get(KEY_FIELD);
                        DocsEnum td = MultiFields.getTermDocsEnum(reader,
                                                                  MultiFields.getDeletedDocs(reader),
                                                                  KEY_FIELD,
                                                                  new BytesRef(url));
			int lastDoc=0;
			while(td.nextDoc() != DocsEnum.NO_MORE_DOCS)
			{
				lastDoc=td.docID();
			}
			assertEquals("Duplicate urls should return last doc",lastDoc, hits[i].doc);
		}
} 
