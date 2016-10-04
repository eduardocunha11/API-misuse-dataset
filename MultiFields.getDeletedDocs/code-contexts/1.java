/**
 * Source: https://github.com/ieure/lucene-solr-snapshot/blob/master/lucene/contrib/queries/src/java/org/apache/lucene/search/DuplicateFilter.java
 */
private OpenBitSet correctBits(IndexReader reader) throws IOException {
    OpenBitSet bits = new OpenBitSet(reader.maxDoc()); //assume all are INvalid
    final Bits delDocs = MultiFields.getDeletedDocs(reader);
    Terms terms = reader.fields().terms(fieldName);
    if (terms != null) {
      TermsEnum termsEnum = terms.iterator();
      DocsEnum docs = null;
      while(true) {
        BytesRef currTerm = termsEnum.next();
        if (currTerm == null) {
          break;
        } else {
          docs = termsEnum.docs(delDocs, docs);
          int doc = docs.nextDoc();
          if (doc != DocsEnum.NO_MORE_DOCS) {
            if (keepMode == KM_USE_FIRST_OCCURRENCE) {
              bits.set(doc);
            } else {
              int lastDoc = doc;
              while (true) {
                lastDoc = doc;
                doc = docs.nextDoc();
                if (doc == DocsEnum.NO_MORE_DOCS) {
                  break;
                }
              }
              bits.set(lastDoc);
            }
          }
        }
      }
    }
    return bits;
}
