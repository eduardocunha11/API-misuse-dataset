/**
 * Source: https://github.com/JoosepHint/Gallery3D_EVO_3D/blob/master/src/com/android/camera/VideoModule.java
 */
private boolean updateEffectSelection() {
        int previousEffectType = mEffectType;
        Object previousEffectParameter = mEffectParameter;
        mEffectType = CameraSettings.readEffectType(mPreferences);
        mEffectParameter = CameraSettings.readEffectParameter(mPreferences);

        if (mEffectType == previousEffectType) {
            if (mEffectType == EffectsRecorder.EFFECT_NONE) return false;
            if (mEffectParameter.equals(previousEffectParameter)) return false;
        }
        Log.v(TAG, "New effect selection: " + mPreferences.getString(
                CameraSettings.KEY_VIDEO_EFFECT, "none"));

        if (mEffectType == EffectsRecorder.EFFECT_NONE) {
            // Stop effects and return to normal preview
            mEffectsRecorder.stopPreview();
            mPreviewing = false;
            return true;
        }
        if (mEffectType == EffectsRecorder.EFFECT_BACKDROPPER &&
            ((String) mEffectParameter).equals(EFFECT_BG_FROM_GALLERY)) {
            // Request video from gallery to use for background
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setDataAndType(Video.Media.EXTERNAL_CONTENT_URI,
                             "video/*");
            i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            mActivity.startActivityForResult(i, REQUEST_EFFECT_BACKDROPPER);
            return true;
        }
        if (previousEffectType == EffectsRecorder.EFFECT_NONE) {
            // Stop regular preview and start effects.
            stopPreview();
            checkQualityAndStartPreview();
        } else {
       // Switch currently running effect
            mEffectsRecorder.setEffect(mEffectType, mEffectParameter);
        }
        return true;
    }
