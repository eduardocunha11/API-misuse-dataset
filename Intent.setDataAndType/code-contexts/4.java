/**
 * Source: https://github.com/JoosepHint/Gallery3D_EVO_3D/blob/master/src/com/android/gallery3d/app/PhotoPage.java
 */ 
protected boolean onItemSelected(MenuItem item) {
		if (mModel == null)
			return true;
		refreshHidingMessage();
		MediaItem current = mModel.getMediaItem(0);
		// This is a shield for monkey when it clicks the action bar
		// menu when transitioning from filmstrip to camera
		if (current instanceof SnailItem)
			return true;
		// TODO: We should check the current photo against the MediaItem
		// that the menu was initially created for. We need to fix this
		// after PhotoPage being refactored.
		if (current == null) {
			// item is not ready, ignore
			return true;
		}
		int currentIndex = mModel.getCurrentIndex();
		Path path = current.getPath();

		DataManager manager = mActivity.getDataManager();
		int action = item.getItemId();
		String confirmMsg = null;
		switch (action) {
		case android.R.id.home: {
			onUpPressed();
			return true;
		}
		case R.id.action_slideshow: {
			Bundle data = new Bundle();
			data.putString(SlideshowPage.KEY_SET_PATH, mMediaSet.getPath()
					.toString());
			data.putString(SlideshowPage.KEY_ITEM_PATH, path.toString());
			data.putInt(SlideshowPage.KEY_PHOTO_INDEX, currentIndex);
			data.putBoolean(SlideshowPage.KEY_REPEAT, true);
			mActivity.getStateManager().startStateForResult(
					SlideshowPage.class, REQUEST_SLIDESHOW, data);
			return true;
		}
		case R.id.action_crop: {
			Activity activity = mActivity;
			Intent intent = new Intent(CropActivity.CROP_ACTION);
			intent.setClass(activity, CropActivity.class);
			intent.setDataAndType(manager.getContentUri(path),
					current.getMimeType()).setFlags(
					Intent.FLAG_GRANT_READ_URI_PERMISSION);
			activity.startActivityForResult(intent, PicasaSource
					.isPicasaImage(current) ? REQUEST_CROP_PICASA
					: REQUEST_CROP);
			return true;
		}
		case R.id.action_trim: {
			Intent intent = new Intent(mActivity, TrimVideo.class);
			intent.setData(manager.getContentUri(path));
			// We need the file path to wrap this into a RandomAccessFile.
			intent.putExtra(KEY_MEDIA_ITEM_PATH, current.getFilePath());
			mActivity.startActivityForResult(intent, REQUEST_TRIM);
			return true;
		}
		case R.id.action_mute: {
			MuteVideo muteVideo = new MuteVideo(current.getFilePath(),
					manager.getContentUri(path), mActivity);
			muteVideo.muteInBackground();
			return true;
		}
		case R.id.action_edit: {
			launchPhotoEditor();
			return true;
		}
		case R.id.action_simple_edit: {
			launchSimpleEditor();
			return true;
		}
		case R.id.action_details: {
			if (mShowDetails) {
				hideDetails();
			} else {
				showDetails();
			}
			return true;
		}
		case R.id.three3d: {
			if (!getPathFromURI(manager.getContentUri(path)).contains("mpo")
					|| !getPathFromURI(manager.getContentUri(path)).contains(
							"jps")) {
				// return true;
			}
			Intent intent = new Intent((Activity) mActivity, View3D.class)
					.putExtra("interlaced",
							getPathFromURI(manager.getContentUri(path)))
					.putExtra("name", mCurrentPhoto.getName());
			((Activity) mActivity).startActivity(intent);
			/*
			 * Intent shareIntent = new Intent();
			 * shareIntent.setAction(Intent.ACTION_SEND);
			 * shareIntent.putExtra(Intent.EXTRA_STREAM,
			 * manager.getContentUri(path));
			 * Toast.makeText(mActivity.getAndroidContext(),
			 * /*getPathFromURI(manager.getContentUri(path))path.toString(),
			 * Toast.LENGTH_LONG).show(); shareIntent.setType("image/jpeg");
			 * shareIntent.setClassName("com.gallery3dplugin",
			 * "com.gallery3dplugin.Gallery3DPlugIn"); ((Activity)
			 * mActivity).startActivity(shareIntent);
			 */
			return true;
		}
		case R.id.action_delete:
			confirmMsg = mActivity.getResources().getQuantityString(
					R.plurals.delete_selection, 1);
		case R.id.action_setas:
		case R.id.action_rotate_ccw:
		case R.id.action_rotate_cw:
		case R.id.action_show_on_map:
			mSelectionManager.deSelectAll();
			mSelectionManager.toggle(path);
			mMenuExecutor.onMenuClicked(item, confirmMsg,
					mConfirmDialogListener);
			return true;
		default:
			return false;
		}
	}
